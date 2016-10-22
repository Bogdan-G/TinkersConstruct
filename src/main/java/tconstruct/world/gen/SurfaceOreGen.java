package tconstruct.world.gen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import tconstruct.util.config.PHConstruct;

public class SurfaceOreGen extends WorldGenerator
{
    /** The block of the ore to be placed using this generator. */
    private Block minableBlock;
    private int minableBlockMeta = 0;

    /** The number of blocks to generate. */
    private int numberOfBlocks;
    private Block[] replaceBlocks;
    private boolean alterSize;

    public SurfaceOreGen(Block b, int meta, int number, boolean changeSize)
    {
        this(b, meta, number, changeSize, Blocks.stone, (Block) Blocks.grass, Blocks.dirt, Blocks.water, Blocks.sand, Blocks.gravel, Blocks.snow);
    }

    public SurfaceOreGen(Block b, int meta, int number, boolean changeSize, Block... target)
    {
        this.minableBlock = b;
        this.numberOfBlocks = number;
        this.replaceBlocks = target;
        this.alterSize = changeSize;
        minableBlockMeta = meta;
    }

    int findGround (World world, int x, int y, int z)
    {
        int returnHeight = -1;
        Block block = world.getBlock(x, y - 1, z);
        if (!world.getBlock(x, y, z).isOpaqueCube() && (block == Blocks.dirt || block == Blocks.grass))
        {
            return y;
        }
        int height = PHConstruct.seaLevel + 64;
        do
        {
            if (height < PHConstruct.seaLevel - 30)
            {
                break;
            }
            Block b = world.getBlock(x, height, z);
            if (b == Blocks.dirt || b == Blocks.grass)
            {
                if (!world.getBlock(x, height + 1, z).isOpaqueCube())
                {
                    returnHeight = height + 1;
                }
                break;
            }
            height--;
        } while (height > 0);
        return returnHeight;
    }

    @Override
    public boolean generate (World world, Random random, int startX, int startY, int startZ)
    {
        if (alterSize)
        {
            startY = findGround(world, startX, startY, startZ);
            if (startY == -1)
                return false;
        }

        float f = random.nextFloat() * (float) Math.PI;
        int blockNumber = numberOfBlocks;
        if (alterSize) blockNumber = numberOfBlocks * 2 / 5 + random.nextInt(numberOfBlocks * 3 / 5);
        float msin = MathHelper.sin(f);
        float mcos = (float) Math.sqrt(1-msin*msin);
        float bn8 = (float) blockNumber / 8.0F;
        float d0 =  ((float) (startX + 8) + msin * bn8);
        float d1 =  ((float) (startX + 8) - msin * bn8);
        float d2 =  ((float) (startZ + 8) + mcos * bn8);
        float d3 =  ((float) (startZ + 8) - mcos * bn8);
        float d4 =  (startY + random.nextInt(3) - 2);
        float d5 =  (startY + random.nextInt(3) - 2);
        float mpibn = (float) Math.PI / (float) blockNumber;

        for (int l = 0; l <= blockNumber; ++l)
        {
            float lbn = (float) l / (float) blockNumber;
            float d6 = d0 + (d1 - d0) * lbn;
            float d7 = d4 + (d5 - d4) * lbn;
            float d8 = d2 + (d3 - d2) * lbn;
            float d9 = random.nextFloat() * bn8 / 2.0f;
            float d10 = (MathHelper.sin((float) l * mpibn) + 1.0F) * d9 + 1.0f;
            //float d11 = (float) (MathHelper.sin((float) l * (float) Math.PI / (float) blockNumber) + 1.0F) * d9 + 1.0f;
            float d102f = d10 / 2.0f;
            int i1 = MathHelper.floor_float(d6 - d102f);
            int j1 = MathHelper.floor_float(d7 - d102f);
            int k1 = MathHelper.floor_float(d8 - d102f);
            int l1 = MathHelper.floor_float(d6 + d102f);
            int i2 = MathHelper.floor_float(d7 + d102f);
            int j2 = MathHelper.floor_float(d8 + d102f);

            for (int k2 = i1; k2 <= l1; ++k2)
            {
                float d12 = ((float) k2 + 0.5f - d6) / (d102f);

                if (d12 * d12 < 1.0f)
                {
                    for (int l2 = j1; l2 <= i2; ++l2)
                    {
                        float d13 = ((float) l2 + 0.5f - d7) / (d102f);

                        if (d12 * d12 + d13 * d13 < 1.0f)
                        {
                            for (int i3 = k1; i3 <= j2; ++i3)
                            {
                                float d14 = ((float) i3 + 0.5f - d8) / (d102f);

                                Block block = world.getBlock(k2, l2, i3);
                                if (d12 * d12 + d13 * d13 + d14 * d14 < 1.0f)
                                {
                                    if (block == null || !world.getBlock(k2, l2, i3).isOpaqueCube())
                                        world.setBlock(k2, l2, i3, this.minableBlock, minableBlockMeta, 2);
                                    else
                                    {
                                        for (int iter = 0; iter < replaceBlocks.length; iter++)
                                        {
                                            if (world.getBlock(k2, l2, i3).isReplaceableOreGen(world, k2, l2, i3, replaceBlocks[iter]))
                                            {
                                                world.setBlock(k2, l2, i3, this.minableBlock, minableBlockMeta, 2);
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return true;
    }
}
