package abyss.world.blocks.force.distribution;

import mindustry.gen.*;
import abyss.world.blocks.force.power.*;
import abyss.world.blocks.force.*;

public class ForceConveyor extends ForceBlock {
	public ForceConveyor(String name) {
		super(name);
		rotate = true;
		maxForce = 500f;
	}

	public class ForceConveyorBuild extends ForceBlock.ForceBlockBuild {

		@Override
		public boolean acceptForce(float force, Building src) {
			if (src instanceof PullingBlock.PullingBlockBuild || src instanceof ForceConveyorBuild) return true;
			return false;
		}

		@Override
		public void updateTile() {
			super.updateTile();
			if (acceptForce(0f, back())) setForce(((ForceBlockBuild) back().forceContainer().force), this);
		}
	}
}