// Di dalam onViewCreated WardrobeFragment.kt
val recyclerView: RecyclerView = view.findViewById(R.id.recyclerViewWardrobe)

// Buat data dummy untuk contoh
val clothingList = listOf(
    ClothingItem(R.drawable.your_shirt_image, "Casual"),
    ClothingItem(R.drawable.your_pants_image, "Formal")
)

val adapter = ClothingAdapter(clothingList)
recyclerView.adapter = adapter
recyclerView.layoutManager = GridLayoutManager(context, 2) // Tampilan grid 2 kolom