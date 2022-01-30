package abyss.world.blocks.force.power;

import arc.util.*;
import arc.math.*;
import arc.graphics.*;
import arc.scene.ui.layout.*;
import mindustry.gen.*;
import abyss.world.blocks.force.*;

public class PullingBlock extends ForceBlock {
	public float pullMagnitude = 1f, releaseMagnitude = 0.2f;

	public PullingBlock(String name, Color forceColor) {
		super(name, forceColor);
		maxForce = 100f;
		configurable = true;
	}

	public class PullingBlockBuild extends ForceBlock.ForceBlockBuild {
		boolean willPull = false;

		@Override
		public void buildConfiguration(Table table) {
			table.button(Icon.settings, () -> {willPull = true;});
		}

		@Override
		public void updateTile() {
			if (willPull) {
				setForce(Math.min(force.force + (Time.delta * pullMagnitude), maxForce));
			} else {
				setForce(Math.max(force.force - (Time.delta * releaseMagnitude), 0f));
			}
		}
	}
}