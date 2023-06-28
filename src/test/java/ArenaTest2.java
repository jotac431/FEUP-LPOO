import com.lpoo2021g68.bandit.Game;
import com.lpoo2021g68.bandit.controller.game.HeroController;
import com.lpoo2021g68.bandit.controller.game.MonsterController;
import com.lpoo2021g68.bandit.controller.game.SwitchController;
import com.lpoo2021g68.bandit.gui.GUI;
import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArenaTest2 {

    private Game game;
    private HeroController heroController;
    private SwitchController switchController;
    @BeforeEach
    void setUp() {
        try {
            this.game = new Game();
            this.heroController = new HeroController(game.getArenas().get(1));
            this.switchController = new SwitchController(game.getArenas().get(1));
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

    }


    @Test
    void openAndCloseDoor() {
        for (int i = 0; i < 11; i++) {
            this.heroController.step(this.game, GUI.ACTION.UP);
            this.switchController.step(this.game, GUI.ACTION.RIGHT);
        }
        for (int i = 0; i < 21; i++) {
            this.heroController.step(this.game, GUI.ACTION.LEFT);
            this.switchController.step(this.game, GUI.ACTION.RIGHT);
        }
        this.heroController.step(this.game, GUI.ACTION.A);
        this.switchController.step(this.game, GUI.ACTION.RIGHT);
        Assertions.assertEquals(false, game.getArenas().get(1).getSwitches().get(0).getWalls().get(0).getOn());
        this.heroController.step(this.game, GUI.ACTION.W);
        this.switchController.step(this.game, GUI.ACTION.RIGHT);
        this.heroController.step(this.game, GUI.ACTION.D);
        this.switchController.step(this.game, GUI.ACTION.RIGHT);
        this.heroController.step(this.game, GUI.ACTION.S);
        this.switchController.step(this.game, GUI.ACTION.RIGHT);
        this.heroController.step(this.game, GUI.ACTION.A);
        this.switchController.step(this.game, GUI.ACTION.RIGHT);
        Assertions.assertEquals(true, game.getArenas().get(1).getSwitches().get(0).getWalls().get(0).getOn());
    }


}