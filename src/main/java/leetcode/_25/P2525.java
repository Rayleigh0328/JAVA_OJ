package leetcode._25;

public class P2525{

    private boolean checkBulky(int length, int width, int height) {
        if (length >= 10_000) return true;
        if (width >= 10_000) return true;
        if (height >= 10_000) return true;
        return (long) length * width * height >= 1_000_000_000;
    }

    private boolean checkHeavy(int mass) {
        return mass >= 100;
    }

    private String getCategory(boolean isBulky, boolean isHeavy) {
        if (isBulky && isHeavy) return "Both";
        if (!isBulky && !isHeavy) return "Neither";
        if (isBulky) return "Bulky";
        return "Heavy";
    }

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean isBulky = checkBulky(length, width, height);
        boolean isHeavy = checkHeavy(mass);
        return getCategory(isBulky, isHeavy);
    }

}
