package abyss.world.blocks.force;

import arc.Core;
import arc.util.*;
import mindustry.ui.*;
import mindustry.gen.*;
import mindustry.world.Block;
import abyss.world.blocks.force.*;

// block that can handle force
public class ForceBlock extends Block{
	public float minForce, maxForce;
	public Color forceColor;

	public ForceBlock(String name, Color forceColor) {
		super(name);
		this.forceColor = forceColor;
		solid = update = true;
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("Force", () entity -> new Bar(
			Core.bundle.get("bar.force"),
			forceColor,
			((ForceBlockBuild) entity).forcef())
		);
	}

	public class ForceBlockBuild extends Building implements ForceBlockc {
		public ForceContainer force = new ForceContainer();

		@Override
		public float forcef() {
			return force.force/maxForce;
		}

		@Override
		public void overloadForce() {
			kill();
		}

		@Override
		public void updateTile() {
			overloadForce();
			setForce(force.force + Time.delta);
		}
	}
}
