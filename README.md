# DataBinding-Sample-With-Adapter
A simple example to use databinding in activity and adapter using kotlin.


## Enabling DataBinding in build.gradle under app module
```gradle
apply plugin: 'kotlin-kapt'

android {
dataBinding {
     enabled true
  }
}

dependencies {
    kapt "com.android.databinding:compiler:$gradle_version"
}
```

## Binding layout with data
```xml
<?xml version="1.0" encoding="utf-8"?>
<layout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto">

    <data>
    <variable
        name="Player"
        type="com.example.databindingdemo.models.Player" />
    </data>

       <ConstraintLayout... /> <!-- UI layout's root element -->

</layout>
```

## Make changes in adapter
```kotlin
class PlayerAdapter(private val context: Context, private val list: MutableList<Player>?) : RecyclerView.Adapter<PlayerAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding: PlayerRowBinding = DataBindingUtil.inflate(inflater, R.layout.player_row,parent,false)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        if(list == null){
            return 0
        }
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.itemBinding.player = list?.get(position)
    }

    class MyViewHolder(val itemBinding: PlayerRowBinding) : RecyclerView.ViewHolder(itemBinding.root){

        private var binding : PlayerRowBinding? = null

        init {
            this.binding = itemBinding
        }

    }

}
```
