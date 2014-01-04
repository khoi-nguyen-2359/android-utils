package fantageek.com.util.adapter;

import android.widget.BaseExpandableListAdapter;

public abstract class DataArrayExpandableAdapter<G,C> extends BaseExpandableListAdapter {

	@Override
	public C getChild(int groupPosition, int childPosition) {
		return null;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return 0;
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		return 0;
	}

	@Override
	public G getGroup(int paramInt) {
		return null;
	}

	@Override
	public int getGroupCount() {
		return 0;
	}

	@Override
	public long getGroupId(int paramInt) {
		return 0;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public boolean isChildSelectable(int paramInt1, int paramInt2) {
		return false;
	}

}
