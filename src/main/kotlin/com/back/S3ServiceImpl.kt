package com.back

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service
import software.amazon.awssdk.services.s3.S3Client

@Profile("!test")
@Service
class S3ServiceImpl(
    private val s3Client: S3Client
) : S3Service {
    override fun getBucketNames(): List<String> {
        return s3Client.listBuckets().buckets().map { it.name() }
    }
}