import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.controller.game.HeroController;
import com.lpoo2021g68.bandit.controller.game.MonsterController;
import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArenaTest1 {

    private Game game;
    private HeroController heroController;
    private MonsterController monsterController;
    @BeforeEach
    void setUp() {
        try {
            this.game = new Game();
            this.heroController = new HeroController(game.getArenas().get(3));
            this.monsterController = new MonsterController(game.getArenas().get(3));
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

    }

    @Test
    void dieToMonster() {
        for (int i = 0; i < 14; i++) {
            this.heroController.step(this.game, GUI.ACTION.LEFT);
            this.monsterController.step(this.game, GUI.ACTION.LEFT);
        }
        this.heroController.step(this.game, GUI.ACTION.D);
        this.monsterController.step(this.game, GUI.ACTION.LEFT);
        Assertions.assertEquals(0, game.getArenas().get(3).getHero().getEnergy());

    }

    @Test
    void killMonsters() {
        int numberMonsters = game.getArenas().get(3).getMonsters().size();
        for (int i = 0; i < 13; i++) {
            this.heroController.step(this.game, GUI.ACTION.LEFT);
            this.monsterController.step(this.game, GUI.ACTION.LEFT);
        }
        this.heroController.step(this.game, GUI.ACTION.A);
        this.monsterController.step(this.game, GUI.ACTION.LEFT);
        this.heroController.step(this.game, GUI.ACTION.A);
        this.monsterController.step(this.game, GUI.ACTION.LEFT);
        this.heroController.step(this.game, GUI.ACTION.A);
        this.monsterController.step(this.game, GUI.ACTION.LEFT);
        int numberMonstersNew = game.getArenas().get(3).getMonsters().size();
        Assertions.assertEquals(-2, numberMonstersNew - numberMonsters);

    }

    @Test
    void openAndCloseDoor() {
        int numberMonsters = game.getArenas().get(3).getMonsters().size();
        for (int i = 0; i < 13; i++) {
            this.heroController.step(this.game, GUI.ACTION.LEFT);
            this.monsterController.step(this.game, GUI.ACTION.LEFT);
        }
        this.heroController.step(this.game, GUI.ACTION.A);
        this.monsterController.step(this.game, GUI.ACTION.LEFT);
        this.heroController.step(this.game, GUI.ACTION.A);
        this.monsterController.step(this.game, GUI.ACTION.LEFT);
        this.heroController.step(this.game, GUI.ACTION.A);
        this.monsterController.step(this.game, GUI.ACTION.LEFT);
        int numberMonstersNew = game.getArenas().get(3).getMonsters().size();
        Assertions.assertEquals(-2, numberMonstersNew - numberMonsters);

    }


}