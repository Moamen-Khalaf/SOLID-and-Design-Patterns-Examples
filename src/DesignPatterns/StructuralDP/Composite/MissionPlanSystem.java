package DesignPatterns.StructuralDP.Composite;

import java.util.ArrayList;
import java.util.List;

// Base interface for messages
interface MissionMessage {
    void execute();
}

// Primitive message class
class PrimitiveMessage implements MissionMessage {
    private String task;

    public PrimitiveMessage(String task) {
        this.task = task;
    }

    @Override
    public void execute() {
        System.out.println("Executing task: " + task);
    }
}

// Composite message class
class CompositeMessage implements MissionMessage {
    private List<MissionMessage> messages = new ArrayList<>();

    public void addMessage(MissionMessage message) {
        messages.add(message);
    }

    public void removeMessage(MissionMessage message) {
        messages.remove(message);
    }

    @Override
    public void execute() {
        for (MissionMessage message : messages) {
            message.execute();
        }
    }
}

// Mission plan generator
class MissionPlanGenerator {
    public MissionMessage createMissionPlan() {
        return new CompositeMessage();
    }

    public PrimitiveMessage createPrimitiveMessage(String task) {
        return new PrimitiveMessage(task);
    }
}

// Main class for testing
public class MissionPlanSystem {
    public static void main(String[] args) {
        MissionPlanGenerator generator = new MissionPlanGenerator();

        // Create primitive messages
        PrimitiveMessage tempTask = generator.createPrimitiveMessage("Collect Temperature Data");
        PrimitiveMessage vibrationTask = generator.createPrimitiveMessage("Measure Vibration Levels");
        PrimitiveMessage photoTask = generator.createPrimitiveMessage("Take Still Shot");

        // Create a composite message
        CompositeMessage compositeTask = new CompositeMessage();
        compositeTask.addMessage(tempTask);
        compositeTask.addMessage(vibrationTask);

        // Create a mission plan
        CompositeMessage missionPlan = (CompositeMessage) generator.createMissionPlan();
        missionPlan.addMessage(compositeTask);
        missionPlan.addMessage(photoTask);

        // Execute the mission plan
        System.out.println("Executing Mission Plan:");
        missionPlan.execute();
    }
}
