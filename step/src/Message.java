public class Message {
    private int phoneBookId;
    private int methodId;
    private int param1;
    private int param2;
    private int param3;

    public Message(int phoneBookId, int methodId, int param1, int param2, int param3) {
        this.phoneBookId = phoneBookId;
        this.methodId = methodId;
        this.param1 = param1;
        this.param2 = param2;
        this.param3 = param3;
    }

    public int encode() {
        return phoneBookId * 10000 + methodId * 1000 + param1 * 100 + param2 * 10 + param3;
    }

    public static Message decode(int encodedMessage) {
        int phoneBookId = encodedMessage / 10000;
        int methodId = (encodedMessage / 1000) % 10;
        int param1 = (encodedMessage / 100) % 10;
        int param2 = (encodedMessage / 10) % 10;
        int param3 = encodedMessage % 10;
        return new Message(phoneBookId, methodId, param1, param2, param3);
    }

    public int getPhoneBookId() {
        return phoneBookId;
    }

    public int getMethodId() {
        return methodId;
    }

    public int getParam1() {
        return param1;
    }

    public int getParam2() {
        return param2;
    }

    public int getParam3() {
        return param3;
    }
}