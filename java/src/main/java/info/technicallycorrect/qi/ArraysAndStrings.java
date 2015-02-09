package info.technicallycorrect.qi;

public class ArraysAndStrings {

    public static boolean uniqueChars(final String input) {
        //Will work only if string is ASCII
        boolean[] bool_char = new boolean[256];
        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i);
            if (bool_char[val])
                return false;
            bool_char[val] = true;
        }
        return true;
    }

    public static boolean uniqueCharsWithoutExtraDataStructure(final String input) {
        return false;
    }

}
