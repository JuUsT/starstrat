package hearc.ch.starstrat.objects;

import android.app.Activity;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import hearc.ch.starstrat.R;
import hearc.ch.starstrat.dataBase.Use.UseBDD;
import hearc.ch.starstrat.model.StrategyListItem;

/**
 * Created by Pierre on 13.01.2015.
 */
public class ImagesViewLaunch {

    List<UnitItem> myListOfUnit;
    Activity myActivity;
    float littleScale, bigScale;
    int nbImagePerLine;
    boolean isVibrate;
    LinearLayout linearAnimation;

    public boolean getIsVibrate(){return isVibrate;}

    public float getLittleScale()
    {
        return littleScale;
    }

    public float getBigScale()
    {
        return bigScale;
    }

    public void setLittleScale(float scale){
        littleScale = scale;
    }

    public void setBigScale(float scale){
        bigScale = scale;
    }

    public LinearLayout getLinearAnimation()
    {
        return linearAnimation;
    }

    public ImagesViewLaunch(List<UnitItem> listUnit, Activity activity)
    {
        myListOfUnit = listUnit;
        myActivity = activity;

        isVibrate = false;
    }

    public void constructImagesView(int height)
    {
        linearAnimation = new LinearLayout(myActivity);

        //Construction des vues avec les images
        linearAnimation.setOrientation(LinearLayout.VERTICAL);

        //Number of image per line
        if(myListOfUnit.size() < 6)
            nbImagePerLine = 1;
        else if(myListOfUnit.size() < 12)
            nbImagePerLine = 2;
        else
            nbImagePerLine = 3;

        //Toast.makeText(myActivity,"size " +myListOfUnit.size(),Toast.LENGTH_LONG).show();
        //foreach unit, get the image
        for(int j = 0; j < myListOfUnit.size(); j+= nbImagePerLine)
        {
            LinearLayout l = new LinearLayout(myActivity);
            l.setOrientation(LinearLayout.HORIZONTAL);

            for(int i = 0; i < nbImagePerLine; i++)
            {
                //Creation of the horizontal image
                ImageView tmp = new ImageView(myActivity);
                /*
                if(myListOfUnit.get(j+i).getIcon() != null)
                    tmp.setImageDrawable(myListOfUnit.get(j+i).getIcon());
                */
                tmp.setImageResource(R.drawable.ic_about);
                l.addView(tmp);

                //if vibrate then isvibrate = true
                if(myListOfUnit.get(i+j).getVibrate()) {
                    isVibrate = true;
                }
            }

            //Put the horizontal image in vertical layout
            linearAnimation.addView(l);
            /*
            linearAnimation.setMinimumWidth(60);
            linearAnimation.setMinimumHeight(60);
            */
        }
    }
}
