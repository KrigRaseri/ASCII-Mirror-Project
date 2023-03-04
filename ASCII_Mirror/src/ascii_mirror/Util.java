package ascii_mirror;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface Util {

    //Fills list with each line of ASCII art.
    static List<String> fillList(BufferedReader file) {
        try {
            List<String> li = new ArrayList<>();
            String line;

            while ((line = file.readLine()) != null) {
                li.add(line);
            }

            return li;

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Finds longest element.
    static int sizeCount(List<String> li) {
        int count = 0;
        for (String s : li) {
            if (s.length() > count) {count = s.length();}
        }
        return count;
    }

    //Adds white space padding to the end of each line so that they are all even.
    static List<String> fixLength (List<String> li) {
        int count = Util.sizeCount(li);
        for (int i = 0; i < li.size(); i++) {
            String cur = li.get(i);
            if (cur.length() != count) {
                int dif = count - cur.length();
                for (int j = 0; j < dif; j++) {
                    cur += " ";
                }
                li.set(i, cur);
            }
        }
        return li;
    }

    //Takes a list of ASCII art lines and flips the picture around.
    static void printMirror(List<String> li) {
        for (String s : li) {
            StringBuilder b = new StringBuilder(s).reverse();
            String r = revChar(b);
            System.out.println(s + " | " + r);
        }
    }

        //Detects certain characters and then flips them.
        static String revChar(StringBuilder revString) {
            for (int j = 0; j < revString.length(); j++) {
                switch (revString.charAt(j)) {
                    case ')':
                        revString.setCharAt(j, '(');
                        break;

                    case '(':
                        revString.setCharAt(j, ')');
                        break;

                    case '/':
                        revString.setCharAt(j, '\\');
                        break;

                    case '\\':
                        revString.setCharAt(j, '/');
                        break;

                    case '[':
                        revString.setCharAt(j, ']');
                        break;

                    case ']':
                        revString.setCharAt(j, '[');
                        break;

                    case '{':
                        revString.setCharAt(j, '}');
                        break;

                    case '}':
                        revString.setCharAt(j, '{');
                        break;

                    case '>':
                        revString.setCharAt(j, '<');
                        break;

                    case '<':
                        revString.setCharAt(j, '>');
                        break;
                }
            }
            return String.valueOf(revString);
        }
    }

