package DesignPatterns.CreationalDP.Builder;

class Robot {
    private String type;
    private String headType;
    private String bodyType;
    private String legsType;
    private int price;

    private Robot(String type, String headType, String bodyType, String legsType, int price) {
        this.type = type;
        this.headType = headType;
        this.bodyType = bodyType;
        this.legsType = legsType;
        this.price = price;
    }

    public static class RobotBuilder {
        private String type;
        private String headType;
        private String bodyType;
        private String legsType;
        private int price;

        public RobotBuilder setType(String type) {
            this.type = type;
            return this;
        }

        public RobotBuilder setHeadType(String headType) {
            this.headType = headType;
            return this;
        }

        public RobotBuilder setBodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public RobotBuilder setLegsType(String legsType) {
            this.legsType = legsType;
            return this;
        }

        public RobotBuilder setPrice(int price) {
            this.price = price;
            return this;
        }

        public Robot buildRobot() {
            return new Robot(type, headType, bodyType, legsType, price);
        }
    }

}

public class RobotBuilder {
    public static void main(String[] args) {
        Robot robotWithBody = new Robot.RobotBuilder().setBodyType("Metal").buildRobot();
        Robot robotWithLegs = new Robot.RobotBuilder().setLegsType("Metal").buildRobot();
    }
}
