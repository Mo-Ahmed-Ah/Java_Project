package master;



import templete.TypesStatusTemp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        TypesStatusTemp typesStatus = new TypesStatusTemp();

        // إضافة حالة جديدة
        typesStatus.addstatus("Pending");

        // استدعاء getall
        List<model.TypesStatus> statusList = typesStatus.getall();
        if (statusList != null && !statusList.isEmpty()) {
            System.out.println("Retrieved Types Status:");
            for (model.TypesStatus status : statusList) {
                System.out.println("ID: " + status.getId() + ", Title: " + status.getStatustitle());
            }
        } else {
            System.out.println("No data retrieved.");
        }

        // استدعاء getStatusByTitle
        model.TypesStatus status = typesStatus.getStatusByTitle("Pending");
        if (status != null) {
            System.out.println("Retrieved status by title: ID: " + status.getId() + ", Title: " + status.getStatustitle());
        } else {
            System.out.println("No status found with the given title.");
        }
    }
}
