package Regex.AdvancedProblems;
class IPAddressValidator {
    public static boolean isValidIP(String ip) {
        if (ip == null || ip.isEmpty()) {
            return false;
        }

        String[] parts = ip.split("\\.");
        if (parts.length != 4) {
            return false;
        }

        try {
            for (String part : parts) {
                int num = Integer.parseInt(part);
                if (num < 0 || num > 255 || (part.startsWith("0") && part.length() > 1)) {
                    return false;
                }
            }
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String[] testIPs = {
                "192.168.1.1",
                "255.255.255.255",
                "0.0.0.0",
                "127.0.0.1",
                "192.168.1.256",
                "192.168.1.",
                "192.168.1.1.1",
                "192.168.1-1",
                "01.1.1.1",
                "1.1.1.01",
                "1..1.1",
                "1.1.1.a",
                ".1.1.1",
                "1.1.1.",
                "1.1..1",
                "1.1.1. ",
                " 1.1.1.1",
                "1.1.1.1 ",
        };

        for (String ip : testIPs) {
            System.out.println(ip + ": " + isValidIP(ip));
        }
    }
}