public class P468 {
    public static void main(String[] args) {
        String s = validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334");
        return;
    }
    public static String validIPAddress(String queryIP) {
        queryIP = "`" + queryIP + "`";
        if(queryIP.indexOf('.') != -1){
            if(checkIPV4(queryIP)){
                return "IPv4";
            }
        }else{
            if(checkIPV6(queryIP)){
                return "IPv6";
            }
        }
        return "Neither";
    }

    public static boolean checkIPV4(String s){
        String[] parts = s.split("\\.");
        if(parts.length != 4)
            return false;
        parts[0] = parts[0].substring(1);
        parts[3] = parts[3].substring(0, parts[3].length() - 1);
        s = s.substring(1, s.length() - 1);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c > '9' || c < '0'){
                if(c != '.'){
                    return false;
                }
            }
        }

        for(int i = 0; i < 4; i++){
            if(parts[i].length() < 1)
                return false;
            if(parts[i].length() > 1 && parts[i].charAt(0) == '0')
                return false;
            if(parts[i].length() > 3)
                return false;
            if(Integer.parseInt(parts[i]) > 255)
                return false;
        }
        return true;
    }

    public static boolean checkIPV6(String s){
        String[] parts = s.split(":");
        if(parts.length != 8)
            return false;
        parts[0] = parts[0].substring(1);
        parts[7] = parts[7].substring(0, parts[7].length() - 1);
        s = s.substring(1, s.length() - 1);

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!(('0' <= c && c <= '9') || ('a' <= c && c <= 'f') || ('A' <= c && c <= 'F'))){
                if(c != ':'){
                    return false;
                }
            }
        }

        for(int i = 0; i < 8; i++){
            if(parts[i].length() < 1 || parts[i].length() > 4)
                return false;
        }
        return true;
    }
}
