import com.lpoo2021g68.bandit.model.DIRECTION;
import com.lpoo2021g68.bandit.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PositionTest {
    private Position position;

    @BeforeEach
    void setUp() {
        position = new Position(10, 10);
    }

    @Test
    void getLeft() {
        Position test = position.getPositionDirection(DIRECTION.LEFT);
        assertEquals(9, test.getX());
    }

    @Test
    void getRight() {
        Position test = position.getPositionDirection(DIRECTION.RIGHT);
        assertEquals(11, test.getX());
    }

    @Test
    void getUp() {
        Position test = position.getPositionDirection(DIRECTION.UP);
        assertEquals(9, test.getY());
    }

    @Test
    void getDown() {
        Position test = position.getPositionDirection(DIRECTION.DOWN);
        assertEquals(11, test.getY());
    }
}