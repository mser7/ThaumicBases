package tb.client.render.item;

import javax.vecmath.Matrix4f;

import DummyCore.Client.AdvancedModelLoader;
import DummyCore.Client.IItemRenderer;
import DummyCore.Client.IModelCustom;
import DummyCore.Client.RPAwareModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("deprecation")
public class NodeManipulatorItemRenderer implements IItemRenderer {
	
	public static final IModelCustom model = AdvancedModelLoader.loadModel(new ResourceLocation("thaumicbases","models/nodeManipulator/nodeManipulator.obj"));
	public static final ResourceLocation genIcon = new ResourceLocation("thaumicbases","textures/blocks/nodeManipulator/baseUVMap.png");

	@Override
	public boolean handleRenderType(ItemStack item, TransformType type) {
		return true;
	}

	@Override
	public void renderItem(TransformType type, ItemStack item) {
		GlStateManager.pushMatrix();
		RenderHelper.disableStandardItemLighting();
		
		GlStateManager.scale(0.5, 0.5, 0.5);
		GlStateManager.translate(1, 0.5, 1);
		Minecraft.getMinecraft().renderEngine.bindTexture(genIcon);
		model.renderAll();
		
		RenderHelper.enableGUIStandardItemLighting();
		GlStateManager.popMatrix();
	}

	@Override
	public Matrix4f handleTransformsFor(ItemStack item, TransformType type) {
		if(type == TransformType.THIRD_PERSON)
			return RPAwareModel.THIRD_PERSON_2D;
		
		return null;
	}

}
