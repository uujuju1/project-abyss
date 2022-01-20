package abyss.type;

import arc.graphics.g2d.Draw;
import arc.struct.Seq;
import arc.util.Time;
import mindustry.gen.*;
import mindustry.type.UnitType;

import abyss.type.draw.*;

public class RotorUnitType extends UnitType {
	public final Seq<DrawRotor> rotors = new Seq<>();
	public boolean spinDeath = true;

	public RotorUnitType(String name) {
		super(name);
		flying = lowAltitude = true;
		constructor = UnitEntity::create;
		engineSize = 0f;
		fallSpeed = 0.007f;
	}

	@Override
	public void update(Unit unit) {
		if (spinDeath) {
			if (unit.health <= 0 || unit.dead) {
				unit.rotation += Time.delta * (fallSpeed * 1000);
			}
		}
	}

	@Override
	public void draw(Unit unit) {
		super.draw(unit);
		applyColor(unit);
		rotors.each(DrawRotor -> DrawRotor.draw(unit));
		Draw.reset();
	}

	@Override
	public void load() {
		super.load();
		rotors.each(DrawRotor::load);
	}
}