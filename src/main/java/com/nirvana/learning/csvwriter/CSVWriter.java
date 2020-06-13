package com.nirvana.learning.csvwriter;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVWriter {

    public static void main(String[] args) throws IOException {
        CSVWriter csvWriter = new CSVWriter();
        csvWriter.givenDataArray_whenConvertToCSV_thenOutputCreated();
        System.out.println("Converted to CSV");

    }

    public void givenDataArray_whenConvertToCSV_thenOutputCreated() throws IOException {
        List<String[]> dataLines = new ArrayList<>();
        dataLines.add(new String[]{
                "Candidate Id", "First Name", "Middle Name", "Last Name", "Email Address", "Primary Phone", "Alternate Phone", "Date of Birth", "Gender", "Marital Status", "PAN", "Physical Disability", "Home Address Line1", "Pincode", "City", "Country", "Last drawn CTC", "Min Annual Salary", "Preferred Location", "Total CTC (Lakhs P.A.):", "Total Years of Experience", "Time Gap", "Notice Period", "Primary school From Date", "Primary school End Date", "Primary school Type Of Program", "Primary school University/Board", "Primary school Institute", "Primary school Specialization", "Primary school Grade/Percentage/CGPA", "Primary school Education Qualification", "Secondary school From Date", "Secondary school End Date", "Secondary school Type Of Program", "Secondary school University/Board", "Secondary school Institute", "Secondary school Specialization", "Secondary school Grade/Percentage/CGPA", "Secondary school Education Qualification", "Graduation From Date", "Graduation End Date", "Graduation Type Of Program", "Graduation University/Board", "Graduation Institute", "Graduation Specialization", "Graduation Grade/Percentage/CGPA", "Graduation Education Qualification", "Post Graduation From Date", "Post Graduation End Date", "Post Graduation Type Of Program", "Post Graduation University/Board", "Post Graduation Institute", "Post Graduation Specialization", "Post Graduation Grade/Percentage/CGPA", "Post Graduation Education Qualification", "Backlog", "Work Experience 1 Start Date", "Work Experience 1 End Date", "Work Experience 1 Employment Type", "Work Experience 1 Title", "Work Experience 1 Company Name", "Work Experience 1 Type of Business", "Work Experience 1 Location", "Work Experience 1 Country", "Work Experience 2 Start Date", "Work Experience 2 End Date", "Work Experience 2 Employment Type", "Work Experience 2 Title", "Work Experience 2 Company Name", "Work Experience 2 Type of Business", "Work Experience 2 Location", "Work Experience 2 Country", "Language 1", "Language 1 Read", "Language 1 Speak", "Language 1 Write", "Language 2", "Language 2 Read", "Language 2 Speak", "Language 2 Write", "Language 3", "Language 3 Read", "Language 3 Speak", "Language 3 Write", "Name of Reference", "Designation of Reference", " Address of Reference", " Contact of Reference", "Applicant Photo", "Resume", "Source"
        });

        String[] str = new String[]{"88995", "Captain", "Ramesh", "Bhan", "ramesh.bhan@mailinator.com", "7878523", "7878523", "13/04/1990", "M", "Single", "PAN167694", "No", "Behind Ganga Baba Hostel Baner", "426194", "KANPUR", "India", "579700", "1340000", "Mumbai", "579000", "2", "1", "30", "12/06/2004", "13/07/2006", "Full Time", "Uttar Pradesh State Board", "Saraswati Vidya Mandir Kanpur", "NA", "92", "10th", "14/02/2007", "25/03/2010", "Full Time", "Uttar Pradesh State Board", "Radha Niketan College Kanpur", "Electronics & Telecommunication", "93", "12th", "14/03/2010", "18/09/2018", "Full Time", "NITA", "Motilal Nehru National Institute of Technology Allahabad", "Electronics & Telecommunication", "81", "BE", "20/07//2018", "22/01/2018", "Full Time", "NITIE", "NITIE Mumbai", "Mining Engineering", "87", "ME", "0", "29/03/2017", "19/09/2018", "Full Time", "Junior Technical Consultant", "TCS", "Manufacturing", "AGRA", "India", "", "", "", "", "", "", "", "", "English", "Good", "Good", "Good", "Hindi", "Good", "Good", "Good", "Marathi", "Good", "Good", "Good", "Guddu", "Software Engineer", "London", "8009800998", "", "", "Naukri.com"};
        int len = str.length;
        for (int i = 0; i < 500; i++) {
            int count = 0;
            String[] newStr = new String[len];
            for (int j = 0; j < len; j++) {
                StringBuilder stringBuilder = new StringBuilder();
                str[j].replace("\"", "");
                stringBuilder.append(str[j]);
                if (str[j].equalsIgnoreCase("Captain") || str[j].equalsIgnoreCase("ramesh.bhan@mailinator.com") || str[j].equalsIgnoreCase("7878523") || str[j].equalsIgnoreCase("PAN167694")) {
                    stringBuilder.append(String.format("%03d", i));
                }
                /* stringBuilder.append(i);*/
                newStr[j] = stringBuilder.toString();
                newStr[j].replace("", "\"");
            }
            dataLines.add(newStr);
        }

        File csvOutputFile = new File("src/main/resources/convertedFile.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            dataLines.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        }
    }

    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }

    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
}
