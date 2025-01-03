package DesignPatterns.StructuralDP.Adabter;

interface Character {
    void move();

    void defend();

    void attack();
}

class SpecialCharacter {
    public void specialMove() {
    }

    public void specialDefend() {
    }

    public void specialAttack() {
    }
}

class SpecialCharacterAdapter implements Character {
    private final SpecialCharacter specialCharacter;

    public SpecialCharacterAdapter(SpecialCharacter specialCharacter) {
        this.specialCharacter = specialCharacter;
    }

    @Override
    public void move() {
        specialCharacter.specialMove();
    }

    @Override
    public void defend() {
        specialCharacter.specialDefend();
    }

    @Override
    public void attack() {
        specialCharacter.specialAttack();
    }
}

class GameEngine {
    public void addCharacter(Character character) {
        character.move();
        character.defend();
        character.attack();
    }
}

public class GamingSystem {
    public static void main(String[] args) {
        SpecialCharacter specialCharacter = new SpecialCharacter();
        Character adaptedCharacter = new SpecialCharacterAdapter(specialCharacter);

        GameEngine gameEngine = new GameEngine();
        gameEngine.addCharacter(adaptedCharacter);
    }
}