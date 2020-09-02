package com.shao.progkievua.homework2.lecture11.groupwebinterface;

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
        answer.append("<table border=\"5\"><tbody><tr><td style=\"text-align: center;\" colspan=\"5\"><strong>Students group</strong></td></tr><tr><td><strong>Surname</strong></td><td><strong>Name</strong></td><td><strong>Age</strong></td><td><strong>Gender</strong></td><td><strong>Dorms</strong></td></tr>");
        for (Student student : students) {
            answer
                    .append("<tr>")
                    .append("<td>").append(student.getSurname()).append("</td>")
                    .append("<td>").append(student.getName()).append("</td>")
                    .append("<td>").append(student.getAge()).append("</td>")
                    .append("<td>").append(student.getGender().toString().toLowerCase()).append("</td>")
                    .append("<td>").append(student.isLivesInDormitory() ? "yes" : "no").append("</td>")
                    .append("</tr>");
        }
        answer.append("</tbody></table>");
        answer.append("<br/><button onclick=\"window.location.href='/bySurname'\">By surname</button>   ");
        answer.append("<button onclick=\"window.location.href='/byName'\">By name</button>   ");
        answer.append("<button onclick=\"window.location.href='/byAge'\">By age</button>   ");
        answer.append("<button onclick=\"window.location.href='/getRecruits'\">Recruits</button>   ");

        return answer.toString();
    }
}
