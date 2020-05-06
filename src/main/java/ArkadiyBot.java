import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ArkadiyBot extends TelegramLongPollingBot {

    @Override
    public void onUpdateReceived(Update update) {

        System.out.println(update.getMessage().getFrom().getFirstName() + ": " + update.getMessage().getText());

        //Send Message
        SendMessage sendMessage = new SendMessage().setChatId(update.getMessage().getChatId());
        sendMessage.setText("Hello " + update.getMessage().getFrom().getFirstName() + "\n" + update.getMessage().getText());

        try {
            ArkadiyBot arkadiyBot = new ArkadiyBot();
            arkadiyBot.execute(sendMessage);
        }

        catch (TelegramApiException e) {
            e.printStackTrace();
        }


    }

    @Override
    public String getBotUsername() {
        return "bot_name";
    }

    @Override
    public String getBotToken() {
        return "code here";
    }
}
