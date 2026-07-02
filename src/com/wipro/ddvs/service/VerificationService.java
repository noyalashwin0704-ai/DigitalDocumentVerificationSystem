package com.wipro.ddvs.service;

import java.util.ArrayList;

import com.wipro.ddvs.entity.Document;
import com.wipro.ddvs.entity.Officer;
import com.wipro.ddvs.entity.User;
import com.wipro.ddvs.entity.VerificationLog;
import com.wipro.ddvs.util.DocumentNotFoundException;
import com.wipro.ddvs.util.InvalidVerificationException;
import com.wipro.ddvs.util.OfficerNotFoundException;
import com.wipro.ddvs.util.UserNotFoundException;

public class VerificationService {

    private ArrayList<User> users;
    private ArrayList<Document> documents;
    private ArrayList<Officer> officers;
    private ArrayList<VerificationLog> logs;

    public VerificationService(ArrayList<User> users,
                               ArrayList<Document> documents,
                               ArrayList<Officer> officers,
                               ArrayList<VerificationLog> logs) {
        this.users = users;
        this.documents = documents;
        this.officers = officers;
        this.logs = logs;
    }

    public void addUser(User u) {
        users.add(u);
    }

    public User findUser(String userId) throws UserNotFoundException {
        for (User u : users) {
            if (u.getUserId().equals(userId)) {
                return u;
            }
        }
        throw new UserNotFoundException("User not found: " + userId);
    }

    public void registerOfficer(Officer o) {
        officers.add(o);
    }

    public Officer findOfficer(String officerId) throws OfficerNotFoundException {
        for (Officer o : officers) {
            if (o.getOfficerId().equals(officerId)) {
                return o;
            }
        }
        throw new OfficerNotFoundException("Officer not found: " + officerId);
    }

    public void uploadDocument(Document d) throws UserNotFoundException {
        findUser(d.getUserId());
        d.setStatus("PENDING");
        documents.add(d);
    }

    public Document findDocument(String documentId) throws DocumentNotFoundException {
        for (Document d : documents) {
            if (d.getDocumentId().equals(documentId)) {
                return d;
            }
        }
        throw new DocumentNotFoundException("Document not found: " + documentId);
    }

    public void assignOfficer(String documentId, String officerId)
            throws DocumentNotFoundException, OfficerNotFoundException, InvalidVerificationException {

        Document d = findDocument(documentId);
        findOfficer(officerId);

        if (d.getAssignedOfficerId() != null) {
            throw new InvalidVerificationException("Document already assigned to officer.");
        }

        d.setAssignedOfficerId(officerId);
        d.setStatus("UNDER_REVIEW");
    }

    public void updateStatus(String documentId, String newStatus)
            throws DocumentNotFoundException, InvalidVerificationException {

        Document d = findDocument(documentId);

        if (!newStatus.equals("PENDING") &&
            !newStatus.equals("UNDER_REVIEW") &&
            !newStatus.equals("VERIFIED") &&
            !newStatus.equals("REJECTED")) {
            throw new InvalidVerificationException("Invalid status: " + newStatus);
        }

        if (d.getStatus().equals("VERIFIED") || d.getStatus().equals("REJECTED")) {
            throw new InvalidVerificationException("Final status cannot be changed.");
        }

        d.setStatus(newStatus);
    }

    public void addVerificationLog(String logId, String documentId,
                                   String officerId, String date, String notes)
            throws InvalidVerificationException, DocumentNotFoundException {

        findDocument(documentId);

        if (notes == null || notes.trim().isEmpty()) {
            throw new InvalidVerificationException("Notes cannot be empty.");
        }

        VerificationLog log = new VerificationLog(logId, documentId, officerId, date, notes);
        logs.add(log);
    }

    public ArrayList<VerificationLog> getLogsForDocument(String documentId) {
        ArrayList<VerificationLog> result = new ArrayList<>();

        for (VerificationLog log : logs) {
            if (log.getDocumentId().equals(documentId)) {
                result.add(log);
            }
        }

        return result;
    }

    public String generateVerificationReport(String documentId) {
        try {
            Document d = findDocument(documentId);

            String report = "\n===== Verification Report =====\n";
            report += "Document ID: " + d.getDocumentId() + "\n";
            report += "User ID: " + d.getUserId() + "\n";
            report += "File Name: " + d.getFileName() + "\n";
            report += "Document Type: " + d.getDocType() + "\n";
            report += "Status: " + d.getStatus() + "\n";
            report += "Assigned Officer ID: " + d.getAssignedOfficerId() + "\n";
            report += "\n--- Verification Logs ---\n";

            for (VerificationLog log : getLogsForDocument(documentId)) {
                report += "Log ID: " + log.getLogId() + "\n";
                report += "Officer ID: " + log.getOfficerId() + "\n";
                report += "Date: " + log.getDate() + "\n";
                report += "Notes: " + log.getNotes() + "\n";
            }

            return report;

        } catch (DocumentNotFoundException e) {
            return e.getMessage();
        }
    }
}