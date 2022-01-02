package abyss.content;

import arc.struct.Seq;
import mindustry.content.*;
import mindustry.content.TechTree.TechNode;
import mindustry.ctype.ContentList;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.*;
import mindustry.type.ItemStack;

public class AbyssTechTree implements ContentList {
	static TechTree.TechNode context = null;

	private static void extendNode (UnlockableContent parent, Runnable children) {
		context = TechTree.all.find(t -> t.content == parent);
		children.run();
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Seq <Objective> objectives, Runnable children) {
		TechNode node = new TechNode(context, content, requirements);
		if (objectives != null) node.objectives = objectives;

		TechNode prev = context;
		context = node;
		children.run();
		context = prev;
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Seq <Objective> objectives) {
		node(content, requirements, objectives, () -> {
		});
	}

	private static void node (UnlockableContent content, Seq <Objective> objectives) {
		node(content, content.researchRequirements(), objectives, () -> {
		});
	}

	private static void node (UnlockableContent content, ItemStack[] requirements) {
		node(content, requirements, Seq.with(), () -> {
		});
	}

	private static void node (UnlockableContent content, ItemStack[] requirements, Runnable children) {
		node(content, requirements, null, children);
	}

	private static void node (UnlockableContent content, Seq <Objective> objectives, Runnable children) {
		node(content, content.researchRequirements(), objectives, children);
	}

	private static void node (UnlockableContent content, Runnable children) {
		node(content, content.researchRequirements(), children);
	}

	private static void node (UnlockableContent block) {
		node(block, () -> {
		});
	}

	private static void nodeProduce (UnlockableContent content, Seq <Objective> objectives, Runnable children) {
		node(content, content.researchRequirements(), objectives.and(new Produce(content)), children);
	}

	private static void nodeProduce (UnlockableContent content, Seq <Objective> objectives) {
		nodeProduce(content, objectives, () -> {
		});
	}

	private static void nodeProduce (UnlockableContent content, Runnable children) {
		nodeProduce(content, Seq.with(), children);
	}

	private static void nodeProduce (UnlockableContent content) {
		nodeProduce(content, Seq.with(), () -> {
		});
	}

	@Override
	public void load() {
		extendNode(Items.plastanium, () -> {
			nodeProduce(AbyssItems.abyss);
		});
		extendNode(Items.metaglass, () -> {
			nodeProduce(AbyssItems.balestenite);
		});
		extendNode(Blocks.plastaniumWall, () -> {
			node(AbyssBlocks.voidWall, Seq.with(new Produce(AbyssItems.abyss)), () -> {
				node(AbyssBlocks.voidWallLarge, () -> {
					node(AbyssBlocks.voidWallHuge);
				});
			});
		});
		extendNode(Blocks.plastaniumCompressor, () -> {
			node(AbyssBlocks.abyssForge, Seq.with(new Produce(Items.thorium)));
		});
		extendNode(Blocks.additiveReconstructor, () -> {
			node(AbyssBlocks.add, ItemStack.with(Items.copper, 1));
		});
		extendNode(Blocks.multiplicativeReconstructor, () -> {
			node(AbyssBlocks.mult, ItemStack.with(Items.copper, 1));
		});
		extendNode(Blocks.exponentialReconstructor, () -> {
			node(AbyssBlocks.exp, ItemStack.with(Items.copper, 1));
		});
		extendNode(Blocks.tetrativeReconstructor, () -> {
			node(AbyssBlocks.tetr, ItemStack.with(Items.copper, 1));
		});
		extendNode(Blocks.navalFactory, () -> {
			node(AbyssBlocks.abyssFactory, Seq.with(new Produce(AbyssItems.abyss)), () -> {
				node(AbyssUnitTypes.antra, () -> {
					node(AbyssUnitTypes.karma, Seq.with(new Research(AbyssBlocks.add)), () -> {
						node(AbyssUnitTypes.kalerbi, Seq.with(new Research(AbyssBlocks.mult)), () -> {
							node(AbyssUnitTypes.kodene, Seq.with(new Research(AbyssBlocks.exp)), () -> {
								node(AbyssUnitTypes.tolonia, Seq.with(new Research(AbyssBlocks.tetr)));
							});
						});
					});
				});
			});
		});
	}
}