public class Resource {
    public static void main(String[] args) {
        System.out.println(getSecuence(11));
    }

    public static int getSecuence(int result) {
        if (result < 1) {
            return result;
        }
        if (result > 100) {
            return result;
        }

        if (result % 2 == 0) {
            return getSecuence(result + 1);
        } else {
            return getSecuence(result - 1);
        }
    }
}