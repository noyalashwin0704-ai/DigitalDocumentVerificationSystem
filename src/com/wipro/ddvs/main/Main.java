package com.wipro.ddvs.main;

import java.util.ArrayList;

import com.wipro.ddvs.entity.Document;
import com.wipro.ddvs.entity.Officer;
import com.wipro.ddvs.entity.User;
import com.wipro.ddvs.entity.VerificationLog;
import com.wipro.ddvs.service.VerificationService;

public class Main {
    public static void main(String[] args) {

        ArrayList<User> users = new ArrayList<>();
        ArrayList<Document> documents = new ArrayList<>();
        ArrayList<Officer> officers = new ArrayList<>();
        ArrayList<VerificationLog> logs = new ArrayList<>();

        users.add(new User("U001", "Amit Shah", "amit@gmail.com"));
        officers.add(new Officer("O001", "Neha Joshi", "Admissions"));

        VerificationService service =
                new VerificationService(users, documents, officers, logs);

        try {
            Document d1 = new Document(
                    "D001",
                    "U001",
                    "marksheet.pdf",
                    "Education Proof",
                    "PENDING",
                    null
            );

            service.uploadDocument(d1);
            service.assignOfficer("D001", "O001");
            service.addVerificationLog(
                    "L001",
                    "D001",
                    "O001",
                    "2025-08-12",
                    "Verified marksheet, details match."
            );
            service.updateStatus("D001", "VERIFIED");

            System.out.println(service.generateVerificationReport("D001"));

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}