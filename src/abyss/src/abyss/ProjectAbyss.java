package abyss;

import arc.*;
import arc.util.*;
import mindustry.*;
import mindustry.content.*;
import mindustry.game.EventType.*;
import mindustry.gen.*;
import mindustry.mod.*;
import mindustry.ui.dialogs.*;

import abyss.content.*;

public class ProjectAbyss extends Mod{
	public ProjectAbyss(){}
	
	@Override
	public void loadContent(){
		new AbyssItems().load();
		new AbyssBullets().load();
		new AbyssStatusEffects().load();
		new AbyssUnitTypes().load();
		new AbyssBlocks().load();
		new AbyssTechTree().load();
	}
}
