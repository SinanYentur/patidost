package com.patidost.app.data.local.entity

enum class SyncState {
    PENDING,      // 1. Yeni eklendi, kuyrukta.
    IN_PROGRESS,  // 2. Worker tarafından "sahiplenildi" (Atomik Kilit).
    SYNCED,       // 3. Sunucu onayladı (Mutlu son).
    RETRY,        // 4. Geçici hata (5xx, Timeout). Backoff sürecinde.
    FATAL         // 5. Kalıcı hata (4xx). Bir daha denenmeyecek.
}