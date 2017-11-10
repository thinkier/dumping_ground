package co.reborncraft.syslogin_banmanager.commands.login;

import co.reborncraft.syslogin_banmanager.SysLogin_BanManager;
import co.reborncraft.syslogin_banmanager.api.futures.login.ChangePasswordFuture;
import co.reborncraft.utils.Utils;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

import java.util.Arrays;

public class ChangePasswordCommand extends Command {
	public ChangePasswordCommand() {
		super("changepassword");
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		if (sender instanceof ProxiedPlayer) {
			if (args.length == 1) {
				String passLower = args[0].toLowerCase();
				if (Arrays.stream(SysLogin_BanManager.getBadPasswords()).anyMatch(passLower::matches)) {
					sender.sendMessage(Utils.parseIntoComp(SysLogin_BanManager.SL_BAD_PASSWORD));
				} else {
					SysLogin_BanManager.getInstance().scheduleFuture(new ChangePasswordFuture(
							((ProxiedPlayer) sender),
							args[0],
							((ProxiedPlayer) sender).getPendingConnection().getAddress().getAddress(),
							state -> sender.sendMessage(Utils.parseIntoComp(SysLogin_BanManager.LOGIN_PREFIX + " " + state.getMessage()))
					));
				}
			} else if (args.length > 1) {
				sender.sendMessage(Utils.parseIntoComp(SysLogin_BanManager.SL_PASSWORD_SPACES_ERROR));
				sender.sendMessage(Utils.parseIntoComp(SysLogin_BanManager.SL_CHANGEPASS_MESSAGE));
			}
		} else {
			sender.sendMessage(Utils.parseIntoComp(SysLogin_BanManager.SL_CHANGEPASS_MESSAGE));
		}
	}
}
