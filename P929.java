import java.util.*;

public class P929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for(String email : emails){
            String head = email.substring(0, email.indexOf('@')).split("\\+")[0];
            String tail = email.substring(email.indexOf('@'));
            head = head.replace(".","");
            System.out.println(head);
            emailSet.add(head + tail);
        }
        return emailSet.size();
    }
}
