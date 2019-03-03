package io.github.wysohn.exampleplugin.main;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import io.github.wysohn.exampleplugin.manager.ManagerExample1;
import io.github.wysohn.rapidframework.pluginbase.PluginAPISupport.APISupport;
import io.github.wysohn.rapidframework.pluginbase.PluginBase;
import io.github.wysohn.rapidframework.pluginbase.PluginConfig;
import io.github.wysohn.rapidframework.pluginbase.PluginLanguage.Language;
import io.github.wysohn.rapidframework.pluginbase.PluginManager;
import io.github.wysohn.rapidframework.pluginbase.commands.SubCommand;
import io.github.wysohn.rapidframework.pluginbase.language.DefaultLanguages;

public class ExamplePlugin extends PluginBase {
	public static class Config extends PluginConfig {
		public String Some_Thing = "Something";
		public ConfigurationSection Some_That = new YamlConfiguration();
		{
			Some_That.set("test1", "val1");
			Some_That.set("test1", "val2");
		}
	}

	public ExamplePlugin() {
		super("somecommand", "example.admin");
	}

	@Override
	protected PluginConfig initConfig() {
		return new Config();
	}

	@Override
	protected void preEnable() {
		// TODO Auto-generated method stub

	}
	
	@Override
	protected void postEnable() {
		// TODO Auto-generated method stub
		
	}	
	
	@Override
	protected void initLangauges(List<Language> languages) {
		Stream.of(Lang.values()).forEach(l -> languages.add(l));
	}

	@Override
	protected void initCommands(List<SubCommand> subcommands) {
		subcommands.add(SubCommand.Builder.forCommand("command1", this, 1)
				.actOnConsole((sender, args) -> {
					sendMessage(sender, DefaultLanguages.Plugin_NotEnabled); 
					return true;
				})
				.actOnPlayer((sender, args)->{
					sendMessage(sender, DefaultLanguages.Plugin_NotEnabled); 
					return true;
				})
				.create());
	}

	@Override
	protected void initAPIs(Map<String, Class<? extends APISupport>> apisupports) {
		
	}

	@Override
	protected void initManagers(List<PluginManager<? extends PluginBase>> pluginmanagers) {
		pluginmanagers.add(new ManagerExample1(this, PluginManager.NORM_PRIORITY));
	}
	
	public static enum Lang implements Language {
		Example_Test1("ABC", "DEF"),
		;
		
		private String[] def;
		
		private Lang(String... def) {
			this.def = def;
		}

		@Override
		public String[] getEngDefault() {
			return def;
		}

	}

}
