package abyss.world.blocks.force;

import arc.Core;
import arc.util.*;
import arc.graphics.*;
import mindustry.ui.*;
import mindustry.gen.*;
import mindustry.graphics.*;
import mindustry.world.Block;
import abyss.world.blocks.force.*;

// block that can handle force
public class ForceBlock extends Block{
	public float maxForce;
	public Color forceColor = Pal.lancerLaser;

	public ForceBlock(String name) {
		super(name);
		solid = update = true;
	}

	@Override
	public void setBars() {
		super.setBars();
		bars.add("Force", entity -> new Bar(
			Core.bundle.get("bar.force"),
			forceColor,
			() -> ((ForceBlockBuild) entity).forcef())
		);
	}

	public class ForceBlockBuild extends Building implements ForceBlockc {
		public ForceContainer force = new ForceContainer();

		@Override
		public ForceContainer forceContainer() {
			return force;
		}

		@Override
		public float forcef() {
			return force.force/maxForce;
		}

		@Override
		public void overloadForce() {
			if (force.force > maxForce) {
				kill();
			}
		}

		@Override
		public void updateTile() {
			overloadForce();
		}
	}
}
