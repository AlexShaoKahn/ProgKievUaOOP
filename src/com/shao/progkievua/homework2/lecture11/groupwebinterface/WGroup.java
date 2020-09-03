package com.shao.progkievua.homework2.lecture11.groupwebinterface;

import com.shao.progkievua.homework2.lecture03.Gender;
import com.shao.progkievua.homework2.lecture03.Student;
import com.shao.progkievua.homework2.lecture09.groupmod.MGroup;

import java.util.List;

public class WGroup extends MGroup {
    private static final long serialVersionUID = -1829152879461429670L;

    public String generateGroupAnswer() {
        return generateAnswer(getRealGroupList());
    }

    public String generateRecruitsAnswer() {
        return generateAnswer(getRealRecruitsList());
    }

    private String generateAnswer(List<Student> students) {
        StringBuilder answer = new StringBuilder();
        answer.append("<table border=\"5\"><tbody><tr><td style=\"text-align: center;\" colspan=\"7\"><strong>Students group</strong></td></tr><tr><td><strong>#</strong></td><td><strong>Surname</strong></td><td><strong>Name</strong></td><td><strong>Age</strong></td><td><strong>Gender</strong></td><td><strong>Dorms</strong></td><td><strong>Delete?</strong></td></tr>");
        int counter = 0;
        for (Student student : students) {
            answer
                    .append("<tr>")
                    .append("<td>").append(++counter).append("</td>")
                    .append("<td>").append(student.getSurname()).append("</td>")
                    .append("<td>").append(student.getName()).append("</td>")
                    .append("<td>").append(student.getAge()).append("</td>")
                    .append("<td>").append(student.getGender().toString().toLowerCase()).append("</td>")
                    .append("<td>").append(student.isLivesInDormitory() ? "yes" : "no").append("</td>")
                    .append("<td>").append("<button onclick=\"window.location.href='/delStudent" + student.hashCode() + "'\">Delete</button>").append("</td>")
                    .append("</tr>");
        }
        answer.append("</tbody></table><br/>");
        answer.append("<button onclick=\"window.location.href='/bySurname'\">By surname</button>   ");
        answer.append("<button onclick=\"window.location.href='/byName'\">By name</button>   ");
        answer.append("<button onclick=\"window.location.href='/byAge'\">By age</button>   ");
        answer.append("<button onclick=\"window.location.href='/getRecruits'\">Recruits</button>   <br/><hr/>");
        answer.append("<form action=\"/addStudent\">");
        answer
                .append("<label for=\"surname\">Surname:</label>  <input type=\"text\" id=\"surname\" name=\"surname\">\t")
                .append("<label for=\"name\">Name:</label>  <input type=\"text\" id=\"name\" name=\"name\">\t");
        answer.append("<label for=\"age\">Age:</label>  <select name=\"selectAge\">");
        for (int i = 16; i < 80; i++) {
            answer.append("<option>");
            answer.append(i);
            answer.append("</option>");
        }
        answer.append("<select>\t");
        answer.append("<label for=\"age\">Gender:</label>  <select name=\"selectGender\">");
        for (Gender gender : Gender.values()) {
            answer.append("<option>");
            answer.append(gender.name());
            answer.append("</option>");

        }
        answer.append("<select>\t");
        answer.append("<label for=\"age\">Dorms:</label>  <select name=\"selectDorms\">");
        answer.append("<option>").append(Boolean.TRUE).append("</option>");
        answer.append("<option>").append(Boolean.FALSE).append("</option>");
        answer.append("<select>\t");
        answer.append("<button ");
        if (students.size() >= 10) answer.append("disabled ");
        answer.append("onclick=\"window.location.href='/addStudent'\">Add student</button>   ");
        if (students.size() >= 10) answer.append("<label>(Maxed out! Delete some students!)</label>");
        answer.append("</form>");

        return answer.toString();
    }
}
