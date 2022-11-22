package bridge;

import com.sun.net.httpserver.Authenticator;

import java.util.List;

public class GameStart {

    private final BridgeGame bridgeGame;
    private  InputView inputView;
    private  OutputView outputView;
    private static int tryNum=1;
    private static boolean regame ;

    GameStart(BridgeGame bridgeGame) {
        this.bridgeGame = bridgeGame;
        inputView = new InputView();
        outputView = new OutputView();
        regame = true;
        StartMoving();
    }

    private void StartMoving() {

        String moving = inputView.readMoving();
        bridgeGame.move(moving);
        List<String> P1 = bridgeGame.getProgress1();
        List<String> P2 = bridgeGame.getProgress2();
        outputView.printMap(P1, P2);
        CheckOutput(P1,P2);
    }
}
