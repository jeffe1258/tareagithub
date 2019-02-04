package miu.facci.com.listView;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import miu.facci.com.R;


public class List_adapter extends ArrayAdapter<RowItem>{

    private Context context;
    private String opción = null;


    public List_adapter(Context context, int resourceId, List<RowItem> entradas) {
        super(context,resourceId,entradas);
       this.context = context;
    }
    private  class  ViewHolder{
        ImageView imageView;
        TextView textName;
        TextView textLevel;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder= null;
        RowItem rowItem = (RowItem) getItem(position);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            if(convertView == null) {
                convertView = inflater.inflate(R.layout.activity_entry, null);
                holder = new ViewHolder();
                holder.textName = (TextView) convertView.findViewById(R.id.nombreFollower);
                holder.imageView = (ImageView) convertView.findViewById(R.id.imageView_entry);
                convertView.setTag(holder);
            }else
                holder=(ViewHolder)convertView.getTag();
                holder.textName.setText(rowItem.getTitle());
                holder.imageView.setImageResource(rowItem.getImageId());

        return convertView;
    }

}
