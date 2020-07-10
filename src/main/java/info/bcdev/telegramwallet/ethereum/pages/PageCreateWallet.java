package info.bcdev.alicewallet.ethereum.pages;

import com.vdurmont.emoji.EmojiParser;
import info.bcdev.alicewallet.Main;
import info.bcdev.alicewallet.Settings;
import info.bcdev.alicewallet.bot.BotInstance;
import info.bcdev.alicewallet.bot.KeyBoards;
import info.bcdev.alicewallet.bot.Keyboard;
import info.bcdev.alicewallet.bot.Tbot;
import info.bcdev.alicewallet.bot.session.Session;
import info.bcdev.alicewallet.ethereum.CreateEW;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static info.bcdev.alicewallet.bot.session.Session.SETTINGS;

public class PageCreateWallet implements KeyBoards, BotInstance {

    private SendMessage sendMessage = new SendMessage();

    public void confirmCreate(Message message) {

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());

        List<String> list = new ArrayList<>();
        String em;

        em = EmojiParser.parseToUnicode("✅");
        list.add(em + " Confirm Create");

        em = EmojiParser.parseToUnicode("\uD83D\uDC48");
        list.add(em+" Back");
        ReplyKeyboardMarkup replyKeyboardMarkup = getReply(2,list);

        String msg ="You confirm the creation of the wallet?";

        sendMessage.setText(msg);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try{
            tbot.execute(sendMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void Create(Message message){
        CreateEW createew = new CreateEW(SETTINGS);

        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(message.getChatId().toString());

        Map<String,String> result = createew.CreateEW();

        List<String> list = new ArrayList<>();
        String msg;
        String msgSeed = "***"+ result.get("seed")+"***";
        if (!result.isEmpty()){
           msg = "Your wallet is Generate with:\n" +
                   "Address: "+ result.get("address")+"\n"+
                    "SeedCode:";
        } else {
            msg = "Wallet is not generate";
        }

        String em = EmojiParser.parseToUnicode("\uD83D\uDC48");
        list.add(em+" Back");

        ReplyKeyboardMarkup replyKeyboardMarkup = getReply(2,list);

        sendMessage.setText(msg);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        try{
            tbot.execute(sendMessage);

            sendMessage.setText(msgSeed);
            tbot.execute(sendMessage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
