package info.bcdev.alicewallet.bot.session;

import info.bcdev.alicewallet.Settings;
import info.bcdev.alicewallet.bot.BotAccess;
import info.bcdev.alicewallet.bot.Tbot;
import info.bcdev.alicewallet.bot.TransactionInstance;
import info.bcdev.alicewallet.ethereum.WalletsInstance;

import java.util.List;

public class Session {

    public static SessionPage SESSION_PAGE;
    public static SendType SEND_TYPE;
    public static SendStep SEND_STEP;
    public static BotAccess BOT_ACCESS;
    public static List<WalletsInstance> WALLET_INSTANCE_LIST;

    public static TransactionInstance SEND_INSTANCE = new TransactionInstance();

    public static String ACTIVE_WALLET;
    public static String DELETE_STEP;

    public static Settings SETTINGS;
    public static Tbot BOT_INSTANCE;
}
