package com.wipro.ddvs.entity;

public class Document {
    private String documentId;
    private String userId;
    private String fileName;
    private String docType;
    private String status;
    private String assignedOfficerId;

    public Document(String documentId, String userId, String fileName,
                    String docType, String status, String assignedOfficerId) {
        this.documentId = documentId;
        this.userId = userId;
        this.fileName = fileName;
        this.docType = docType;
        this.status = status;
        this.assignedOfficerId = assignedOfficerId;
    }

    public String getDocumentId() {
        return documentId;
    }

    public String getUserId() {
        return userId;
    }

    public String getFileName() {
        return fileName;
    }

    public String getDocType() {
        return docType;
    }

    public String getStatus() {
        return status;
    }

    public String getAssignedOfficerId() {
        return assignedOfficerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAssignedOfficerId(String assignedOfficerId) {
        this.assignedOfficerId = assignedOfficerId;
    }
}