// Texture Source that takes a Bitmap
public class BitmapTextureAtlasSource extends BaseTextureAtlasSource implements IBitmapTextureAtlasSource 
{
    private Bitmap mBitmap;
 
    public BitmapTextureAtlasSource(Bitmap pBitmap) {
    	super(0,0);
        this.mBitmap = pBitmap.copy(Bitmap.Config.ARGB_8888, false);
    }
 
    @Override
    public int getWidth() {
        return mBitmap.getWidth();
    }
 
    @Override
    public int getHeight() {
        return mBitmap.getHeight();
    }
 
    @Override
    public BitmapTextureAtlasSource clone() {
        return new BitmapTextureAtlasSource(Bitmap.createBitmap(mBitmap));
    }
 
	@Override
	public Bitmap onLoadBitmap(Config pBitmapConfig)
	{
		return mBitmap;
	}
}

// Usage:
BitmapTextureAtlasSource source = new BitmapTextureAtlasSource(pBitmap);
BitmapTextureAtlas texture = new BitmapTextureAtlas(mTextureSizeX, mTextureSizeY);
texture.addTextureAtlasSource(source, 0, 0);
mEngine.getTextureManager().loadTexture(texture);
TextureRegion region = new TextureRegion(texture, 0, 0, texture.getWidth(), texture.getHeight());
