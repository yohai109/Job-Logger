package com.example.joblogger.screens.jobslist.longclickdialog

import android.os.Bundle
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.joblogger.baseclasses.BaseBottomSheetDialogFragment
import com.example.joblogger.databinding.DialogJobListLongClickBinding
import com.example.joblogger.local.model.JobStatus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class JobLongClickDialog : BaseBottomSheetDialogFragment<DialogJobListLongClickBinding>(
    DialogJobListLongClickBinding::inflate
) {
    private val viewModel: JobListLongClickViewModel by viewModels()
    private val arg: JobLongClickDialogArgs by navArgs()
    private var jobId: String? = null

    override fun DialogJobListLongClickBinding.initUI() {
        marAsNoAction.setOnClickListener {
            jobId?.let { id -> viewModel.updateStatus(id, JobStatus.No) }
            this@JobLongClickDialog.dismiss()
        }

        marAsArchiveAction.setOnClickListener {
            jobId?.let { id -> viewModel.updateStatus(id, JobStatus.Old) }
            this@JobLongClickDialog.dismiss()
        }
        marAsYesAction.setOnClickListener {
            jobId?.let { id -> viewModel.updateStatus(id, JobStatus.Yes) }
            this@JobLongClickDialog.dismiss()
        }
        marAsOnGoingAction.setOnClickListener {
            jobId?.let { id -> viewModel.updateStatus(id, JobStatus.OnGoing) }
            this@JobLongClickDialog.dismiss()
        }
        deleteAction.setOnClickListener {
            jobId?.let { id -> viewModel.deleteJob(id) }
            this@JobLongClickDialog.dismiss()
        }
    }

    override fun initObservers() {

    }

    override fun Bundle.initArguments() {
        jobId = arg.jobId
    }
}