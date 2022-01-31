package abyss.world.blocks.force.distribution;

import mindustry.gen.*;
import abyss.world.blocks.force.power.*;
import abyss.world.blocks.force.ForceBlock;

public class ForceConveyor extends ForceBlock {
	public ForceConveyor(String name) {
		super(name);
		rotate = true;
		maxForce = 500f;
	}

	public class ForceConveyorBuild extends ForceBlock.ForceBlockBuild {

		// a very unefficient solution
		@Override
		public boolean acceptForce(float force, Building src) {
			if (src instanceof ForceBlock.ForceBlockBuild && ((ForceBlockBuild) back()).outputsForce(0f, this)) {
				ForeBlockBuild back = ((ForceBlockBuild) back());
				if (back instanceof ForceConveyorBuild && back.rotdeg() == this.rotdeg()) {
					return true;
				}
				if (back instanceof PullingBlock.PullingBlockBuild && back.front() == this) {
					return true;
				}
			}
			return false;
		}

		@Override
		public void updateTile() {
			super.updateTile();
			if (acceptForce(0f, back())) setForce(((ForceBlockBuild) back()).forceContainer().force, this);
		}
	}
}