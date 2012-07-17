package nl.ordina.rogier.mijnkookschrift.client.view;

import com.google.gwt.user.client.Command;

public class MenuCommandView implements Command {

    final HistoryToken historyToken;

    public MenuCommandView(HistoryToken historyToken) {
        this.historyToken = historyToken;
    }

    @Override
    public void execute() {
        historyToken.fire();
    }

}
