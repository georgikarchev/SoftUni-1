package myHandler.http;

public final class HTMLEncoder {
    private HTMLEncoder() { }

    public static String escapeHTML(String s) {
        StringBuilder out = new StringBuilder(Math.max(16, s.length()));
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c > 127 || c == '"' || c == '<' || c == '>' || c == '&') {
                out.append("&#").append((int) c).append(';');
            } else {
                out.append(c);
            }
        }
        return out.toString();
    }
}