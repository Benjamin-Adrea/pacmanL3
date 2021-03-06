package model.entities.players;

import model.Direction;
import model.Score;
import model.effects.Effect;
import model.entities.characters.Character;

import java.io.Serializable;
import java.util.List;

public abstract class Player implements Serializable {

    protected Character character;
    protected Score score;

    public Player(Character character) {
        this.character = character;
        score = new Score();
    }

    public List<Effect> getEffects(){
        return character.getEffets();
    }

    public Character getCharacter() {
        return character;
    }

    public int looseLife(int nb){
        return character.looseXLife(nb);
    }
    public int looseOneLife(){
        return looseLife(1);
    }

    public void upLifeBy(int nb){
        character.addLife(1);
    }
    public void upLife(){
        upLifeBy(1);
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public void setDirection(Direction direction){
        character.setDirection(direction);
    }

    public Direction getDirection (){
        return character.getDirection();
    }

    public Direction getMove(){return getDirection();}

    public boolean isAffectedBy(Class c){
        return character.hasEffect(c);
    }

    public void upScore(int val){
        if (character.hasDoublePoint())
            val *= 2;
        score.up(val);
    }

    public int getScore(){
        return score.getScore();
    }

    public void resetScore(){
        score.reset();
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public void decreaseEffect(){
        character.dicreaseEffectDuration();
    }
}
