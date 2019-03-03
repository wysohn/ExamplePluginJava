package io.github.wysohn.exampleplugin.manager;

import java.io.File;

import io.github.wysohn.exampleplugin.main.ExamplePlugin;
import io.github.wysohn.rapidframework.pluginbase.PluginManager;

public class ManagerExample1 extends PluginManager<ExamplePlugin> {
	
	public ManagerExample1(ExamplePlugin base, int loadPriority) {
		super(base, loadPriority);
	}

	@Override
	protected void onEnable() throws Exception {
		
	}

	@Override
	protected void onDisable() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onReload() throws Exception {
		// TODO Auto-generated method stub
		
	}

	private class Config extends ManagerConfig{
		
	}
	
	@Override
	protected PluginManager<ExamplePlugin>.ManagerConfig initConfig(File folder) {
		return new Config();
	}
}
