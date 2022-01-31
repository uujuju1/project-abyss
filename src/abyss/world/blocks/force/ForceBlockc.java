package abyss.world.blocks.force;

import arc.graphics.Color;
import arc.util.Nullable;
import mindustry.gen.Building;
import abyss.world.blocks.force.ForceContainer;
// based from ER's pulse system
public interface ForceBlockc {
	// default efficiency of the force block
	default float forceEfficiency() {
		return 1f;
	}

	// force container
	default ForceContainer forceContainer() {return null;}

	// set force
	default void setForce(float force, @Nullable Building building) {
		forceContainer().force = force;
	}
	default void setForce(float force) {
		setForce(force, null);
	}

	// userful in stuff that needs a list on how what to get force
	default boolean acceptForce(float force, Building src) {
		return true;
	}

	// extra stuff
	default void drawForce() {}
	default void overloadForce() {}
	default float forcef() {return 0f;}
}