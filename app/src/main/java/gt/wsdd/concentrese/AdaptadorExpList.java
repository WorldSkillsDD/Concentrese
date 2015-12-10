package gt.wsdd.concentrese;

import android.content.Context;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by WorldSkills on 09/12/2015.
 */
public class AdaptadorExpList extends BaseExpandableListAdapter {
    private Context context;
    private List<String> grupos;
    private HashMap<String, List<Partida>> items;

    public AdaptadorExpList(Context context, List<String> grupos, HashMap<String, List<Partida>> items) {
        this.context = context;
        this.grupos = grupos;
        this.items = items;
    }

    @Override
    public int getGroupCount() {
        return grupos.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return items.get(grupos.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return grupos.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return items.get(grupos.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String nombreGrupo = getGroup(groupPosition).toString();
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exp_grupo, null);
        }
        TextView tvNombreGrupo = (TextView) convertView.findViewById(R.id.expNombreGrupo);
        tvNombreGrupo.setText(nombreGrupo);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        //final String childText = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exp_item, null);
        }
        TextView tvItem = (TextView) convertView.findViewById(R.id.tvNickname);
        Partida partida = (Partida)items.get(grupos.get(groupPosition)).get(childPosition);
        tvItem.setText(partida.getNickname());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
