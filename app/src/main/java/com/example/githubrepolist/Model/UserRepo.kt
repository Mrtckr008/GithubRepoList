package com.example.githubrepolist.Model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


open class UserRepo {
    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("node_id")
    @Expose
     val nodeId: String? = null
    @SerializedName("name")
    @Expose
     val name: String? = null
    @SerializedName("full_name")
    @Expose
     val fullName: String? = null
    @SerializedName("")
    @Expose
     val unknown: Boolean? = null
    @SerializedName("owner")
    @Expose
     val owner: Owner? = null
    @SerializedName("html_url")
    @Expose
     val htmlUrl: String? = null
    @SerializedName("description")
    @Expose
     val description: Any? = null
    @SerializedName("fork")
    @Expose
     val fork: Boolean? = null
    @SerializedName("url")
    @Expose
     val url: String? = null
    @SerializedName("forks_url")
    @Expose
     val forksUrl: String? = null
    @SerializedName("keys_url")
    @Expose
     val keysUrl: String? = null
    @SerializedName("collaborators_url")
    @Expose
     val collaboratorsUrl: String? = null
    @SerializedName("teams_url")
    @Expose
     val teamsUrl: String? = null
    @SerializedName("hooks_url")
    @Expose
     val hooksUrl: String? = null
    @SerializedName("issue_events_url")
    @Expose
     val issueEventsUrl: String? = null
    @SerializedName("events_url")
    @Expose
     val eventsUrl: String? = null
    @SerializedName("assignees_url")
    @Expose
     val assigneesUrl: String? = null
    @SerializedName("branches_url")
    @Expose
     val branchesUrl: String? = null
    @SerializedName("tags_url")
    @Expose
     val tagsUrl: String? = null
    @SerializedName("blobs_url")
    @Expose
     val blobsUrl: String? = null
    @SerializedName("git_tags_url")
    @Expose
     val gitTagsUrl: String? = null
    @SerializedName("git_refs_url")
    @Expose
     val gitRefsUrl: String? = null
    @SerializedName("trees_url")
    @Expose
     val treesUrl: String? = null
    @SerializedName("statuses_url")
    @Expose
     val statusesUrl: String? = null
    @SerializedName("languages_url")
    @Expose
     val languagesUrl: String? = null
    @SerializedName("stargazers_url")
    @Expose
     val stargazersUrl: String? = null
    @SerializedName("contributors_url")
    @Expose
     val contributorsUrl: String? = null
    @SerializedName("subscribers_url")
    @Expose
     val subscribersUrl: String? = null
    @SerializedName("subscription_url")
    @Expose
     val subscriptionUrl: String? = null
    @SerializedName("commits_url")
    @Expose
     val commitsUrl: String? = null
    @SerializedName("git_commits_url")
    @Expose
     val gitCommitsUrl: String? = null
    @SerializedName("comments_url")
    @Expose
     val commentsUrl: String? = null
    @SerializedName("issue_comment_url")
    @Expose
     val issueCommentUrl: String? = null
    @SerializedName("contents_url")
    @Expose
     val contentsUrl: String? = null
    @SerializedName("compare_url")
    @Expose
     val compareUrl: String? = null
    @SerializedName("merges_url")
    @Expose
     val mergesUrl: String? = null
    @SerializedName("archive_url")
    @Expose
     val archiveUrl: String? = null
    @SerializedName("downloads_url")
    @Expose
     val downloadsUrl: String? = null
    @SerializedName("issues_url")
    @Expose
     val issuesUrl: String? = null
    @SerializedName("pulls_url")
    @Expose
     val pullsUrl: String? = null
    @SerializedName("milestones_url")
    @Expose
     val milestonesUrl: String? = null
    @SerializedName("notifications_url")
    @Expose
     val notificationsUrl: String? = null
    @SerializedName("labels_url")
    @Expose
     val labelsUrl: String? = null
    @SerializedName("releases_url")
    @Expose
     val releasesUrl: String? = null
    @SerializedName("deployments_url")
    @Expose
     val deploymentsUrl: String? = null
    @SerializedName("created_at")
    @Expose
     val createdAt: String? = null
    @SerializedName("updated_at")
    @Expose
     val updatedAt: String? = null
    @SerializedName("pushed_at")
    @Expose
     val pushedAt: String? = null
    @SerializedName("git_url")
    @Expose
     val gitUrl: String? = null
    @SerializedName("ssh_url")
    @Expose
     val sshUrl: String? = null
    @SerializedName("clone_url")
    @Expose
     val cloneUrl: String? = null
    @SerializedName("svn_url")
    @Expose
     val svnUrl: String? = null
    @SerializedName("homepage")
    @Expose
     val homepage: Any? = null
    @SerializedName("size")
    @Expose
     val size: Int? = null
    @SerializedName("stargazers_count")
    @Expose
     val stargazersCount: Int? = null
    @SerializedName("watchers_count")
    @Expose
     val watchersCount: Int? = null
    @SerializedName("language")
    @Expose
     val language: String? = null
    @SerializedName("has_issues")
    @Expose
     val hasIssues: Boolean? = null
    @SerializedName("has_projects")
    @Expose
     val hasProjects: Boolean? = null
    @SerializedName("has_downloads")
    @Expose
     val hasDownloads: Boolean? = null
    @SerializedName("has_wiki")
    @Expose
     val hasWiki: Boolean? = null
    @SerializedName("has_pages")
    @Expose
     val hasPages: Boolean? = null
    @SerializedName("forks_count")
    @Expose
     val forksCount: Int? = null
    @SerializedName("mirror_url")
    @Expose
     val mirrorUrl: Any? = null
    @SerializedName("archived")
    @Expose
     val archived: Boolean? = null
    @SerializedName("disabled")
    @Expose
     val disabled: Boolean? = null
    @SerializedName("open_issues_count")
    @Expose
     val openIssuesCount: Int? = null
    @SerializedName("license")
    @Expose
     val license: Any? = null
    @SerializedName("forks")
    @Expose
     val forks: Int? = null
    @SerializedName("open_issues")
    @Expose
     val openIssues: Int? = null
    @SerializedName("watchers")
    @Expose
     val watchers: Int? = null
    @SerializedName("default_branch")
    @Expose
     val defaultBranch: String? = null
}

class Owner {
    @SerializedName("login")
    @Expose
    var login: String? = null
    @SerializedName("id")
    @Expose
    var id: Int? = null
    @SerializedName("node_id")
    @Expose
    var nodeId: String? = null
    @SerializedName("avatar_url")
    @Expose
    var avatarUrl: String? = null
    @SerializedName("gravatar_id")
    @Expose
    var gravatarId: String? = null
    @SerializedName("url")
    @Expose
    var url: String? = null
    @SerializedName("html_url")
    @Expose
    var htmlUrl: String? = null
    @SerializedName("followers_url")
    @Expose
    var followersUrl: String? = null
    @SerializedName("following_url")
    @Expose
    var followingUrl: String? = null
    @SerializedName("gists_url")
    @Expose
    var gistsUrl: String? = null
    @SerializedName("starred_url")
    @Expose
    var starredUrl: String? = null
    @SerializedName("subscriptions_url")
    @Expose
    var subscriptionsUrl: String? = null
    @SerializedName("organizations_url")
    @Expose
    var organizationsUrl: String? = null
    @SerializedName("repos_url")
    @Expose
    var reposUrl: String? = null
    @SerializedName("events_url")
    @Expose
    var eventsUrl: String? = null
    @SerializedName("received_events_url")
    @Expose
    var receivedEventsUrl: String? = null
    @SerializedName("type")
    @Expose
    var type: String? = null
    @SerializedName("site_admin")
    @Expose
    var siteAdmin: Boolean? = null
}