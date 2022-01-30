package abyss.world.blocks.force.power;

import arc.Core;
import arc.util.*;
import arc.math.*;
import arc.graphics.*;
import arc.graphics.g2d.*;
import arc.scene.ui.layout.*;
import mindustry.gen.*;
import abyss.world.blocks.force.*;

public class PullingBlock extends ForceBlock {
	public float pullMagnitude = 1f, releaseMagnitude = 0.2f;
	public Color cableColorFrom, cableColorTo;
	public TextureRegion bottom, cable, top;

	public PullingBlock(String name) {
		super(name);
		maxForce = 100f;
		configurable = true;
		rotate = true;
	}

	@Override
	public void load() {
		super.load();
		bottom = Core.atlas.find(name + "-bottom");
		cable = Core.atlas.find(name + "-cable");
		top = Core.atlas.find(name + "-top");
	}

	public class PullingBlockBuild extends ForceBlock.ForceBlockBuild {
		boolean willPull = false;

		@Override
		public void buildConfiguration(Table table) {
			table.button(Icon.settings, () -> {willPull = true;});
		}

		@Override
		public void draw() {
			Draw.rect(bottom, x, y, rotdeg());
			Draw.color(cableColorFrom.lerp(cableColorTo, forcef()));
			Draw.rect(cable, x, y, rotdeg());
			Draw.color();
			super.draw();
			Draw.rect(top, x, y, rotdeg() + (forcef() * 720f));
		}

		@Override
		public void updateTile() {
			super.updateTile();
			if (willPull) {
				setForce(Math.min(force.force + (Time.delta * pullMagnitude), maxForce), this);
				if (force.force == maxForce) willPull = false;
			} else {
				setForce(Math.max(force.force - (Time.delta * releaseMagnitude), 0f), this);
			}
		}
	}
}