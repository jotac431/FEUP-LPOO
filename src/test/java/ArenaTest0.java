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

class ArenaTest0 {

    private Game game;
    private HeroController heroController;
    private MonsterController monsterController;
    @BeforeEach
    void setUp() {
        try {
            this.game = new Game();
            this.heroController = new HeroController(game.getArenas().get(0));
            this.monsterController = new MonsterController(game.getArenas().get(0));
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }

    }

    @Test
    void goUpThreeSpaces() {
        int posY = this.game.getArenas().get(0).getHero().getPosition().getY();

        this.heroController.step(this.game, GUI.ACTION.UP);
        this.heroController.step(this.game, GUI.ACTION.UP);
        this.heroController.step(this.game, GUI.ACTION.UP);
        int newPosY = this.game.getArenas().get(0).getHero().getPosition().getY();
        Assertions.assertEquals(-3, newPosY - posY);
    }

    @Test
    void goDownThreeSpacesAndHitWall() {
        int posY = this.game.getArenas().get(0).getHero().getPosition().getY();

        this.heroController.step(this.game, GUI.ACTION.DOWN);
        this.heroController.step(this.game, GUI.ACTION.DOWN);
        this.heroController.step(this.game, GUI.ACTION.DOWN);
        int newPosY = this.game.getArenas().get(0).getHero().getPosition().getY();
        Assertions.assertEquals(2, newPosY - posY);
    }


}